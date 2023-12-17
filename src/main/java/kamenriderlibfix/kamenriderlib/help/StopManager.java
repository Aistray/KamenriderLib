package kamenriderlibfix.kamenriderlib.help;

import  net.minecraft.world.entity.Entity;
import org.apache.commons.compress.utils.Lists;

import java.util.List;
import java.util.UUID;

public class StopManager {
    private static boolean stop;
    private static final List<Entity> stopWhitelist = Lists.newArrayList();
    public static void setStop(boolean s){
        stop = s;
    }
    public static  boolean getStop(){
        return stop;
    }
    private static boolean isInStopWhiteList(Entity entity) {
        return stopWhitelist.contains(entity);
    }
    public static void addToStopWhiteList(Entity entity) {
        if (!stopWhitelist.contains(entity)) {
            stopWhitelist.add(entity);
        }
    }
    public static boolean canEntityBeStop(Entity entity){
        if(entity==null) {
            return false;
        }
        else if (isInStopWhiteList(entity)) {
            return false;
        }
        else {
            return true;
        }
    }
}
