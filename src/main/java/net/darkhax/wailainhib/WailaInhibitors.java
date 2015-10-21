package net.darkhax.wailainhib;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.darkhax.wailainhib.common.CommonProxy;
import net.darkhax.wailainhib.handler.ConfigurationHandler;

@Mod(modid = "wailainhib", name = "Waila Inhibitors", version = "1.0.0", guiFactory = "net.darkhax.wailainhib.client.gui.GuiFactoryWailaInhib", dependencies = "required-after:Waila;after:wailaevents")
public class WailaInhibitors {
    
    @SidedProxy(serverSide = "net.darkhax.wailainhib.common.CommonProxy", clientSide = "net.darkhax.wailainhib.client.ClientProxy")
    public static CommonProxy proxy;
    
    @Mod.Instance("wailainhib")
    public static WailaInhibitors instance;
    
    @Mod.EventHandler
    public void preInit (FMLPreInitializationEvent event) {
        
        new ConfigurationHandler(event.getSuggestedConfigurationFile());
        proxy.preInit();
    }
    
    @Mod.EventHandler
    public void init (FMLInitializationEvent event) {
        
        if (ConfigurationHandler.factorNausea) {
            
            FMLInterModComms.sendMessage("Waila", "register", "net.darkhax.wailainhib.providers.InhibTileProvider.registerAddon");
            FMLInterModComms.sendMessage("Waila", "register", "net.darkhax.wailainhib.providers.InhibEntityProvider.registerAddon");
        }
    }
}
