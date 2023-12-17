package kamenriderlibfix.kamenriderlib;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(KamenriderLib.MOD_ID)
public class KamenriderLib {
    public static final String MOD_ID = "kamenriderlib";

    public KamenriderLib() {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
