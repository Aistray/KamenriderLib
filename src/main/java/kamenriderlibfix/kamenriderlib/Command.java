package kamenriderlibfix.kamenriderlib;

import com.mojang.brigadier.arguments.BoolArgumentType;
import kamenriderlibfix.kamenriderlib.command.StopCommand;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Command {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("stop_time").then(Commands.argument("boolean", BoolArgumentType.bool()).then(Commands.argument("player", EntityArgument.players()).executes(a->{
                            Entity player = a.getSource().getEntity();
                            ServerLevel world = a.getSource().getLevel();
                            if (player == null)
                                player = FakePlayerFactory.getMinecraft(world);
                            StopCommand.run(a, false,player);
                            return 0;}))));
    }
}
