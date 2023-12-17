package kamenriderlibfix.kamenriderlib.command;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.context.CommandContext;
import kamenriderlibfix.kamenriderlib.help.StopManager;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class StopCommand{
    public static void run(CommandContext<CommandSourceStack> context, boolean can, Entity player) {
        StopManager.setStop(BoolArgumentType.getBool(context, "boolean"));
        StopManager.addToStopWhiteList(player);
    }
}
