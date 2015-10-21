package net.darkhax.wailainhib.handler;

import java.io.File;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {
    
    public static Configuration config;
    
    public static boolean factorBlindness = true;
    public static boolean factorNausea = true;
    public static boolean factorDarkness = true;
    public static boolean factorDaylight = true;
    public static int lightThreshold = 3;
    
    public static String[] fakeBlocks = { "diamond_block", "waterlily", "mycelium", "dragon_egg", "quartz_ore" };
    public static String[] fakeMobs = { "Creeper", "Skeleton", "Zombie", "Witch", "MushroomCow", "Pig", "Cow", "EnderCrystal" };
    
    public ConfigurationHandler(File file) {
        
        config = new Configuration(file);
        FMLCommonHandler.instance().bus().register(this);
        syncConfigData();
    }
    
    @SubscribeEvent
    public void onConfigChange (ConfigChangedEvent.OnConfigChangedEvent event) {
        
        if (event.modID.equals("wailainhib")) {
            syncConfigData();
        }
    }
    
    private void syncConfigData () {
        
        factorBlindness = config.getBoolean("factorBlindness", "general", factorBlindness, "If this is set to true, the Waila HUD will be unavailable to players with the Blindness debuf.");
        factorNausea = config.getBoolean("factorNausea", "general", factorNausea, "If this is set to true, the Waila HUD will show incorrect data in the Hud.");
        factorDarkness = config.getBoolean("factorDarkness", "general", factorDarkness, "If this is set to true, the Waila HUD will become unavailable if the player is in a dark area.");
        factorDaylight = config.getBoolean("factorDaylight", "general", factorDaylight, "If this is set to true, daylight will be factored into the darkness calculation.");
        lightThreshold = config.getInt("lightThreshhold", "general", lightThreshold, 0, 15, "The lowest possible light level that the Waila HUD will be visible at.");
        fakeBlocks = config.getStringList("fakeBlocks", "general", fakeBlocks, "A list of ids for fake blocks. These will randomly override blocks in the HUD if a player has confusion.");
        fakeMobs = config.getStringList("fakeMobs", "general", fakeMobs, "A list of fake mobs that will randomly override a mob within the HUD when the player is confused.");
        
        if (config.hasChanged()) {
            config.save();
        }
    }
}
