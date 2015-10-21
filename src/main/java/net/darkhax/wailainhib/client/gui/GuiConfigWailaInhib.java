package net.darkhax.wailainhib.client.gui;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.darkhax.wailainhib.handler.ConfigurationHandler;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

public class GuiConfigWailaInhib extends GuiConfig {
    
    static Configuration cfg = ConfigurationHandler.config;
    static ConfigurationHandler cfgh;
    
    public GuiConfigWailaInhib(GuiScreen parent) {
        
        super(parent, generateConfigList(), "wailainhib", false, false, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.config.toString()));
    }
    
    public static List<IConfigElement> generateConfigList () {
        
        ArrayList<IConfigElement> elements = new ArrayList();
        for (String name : cfg.getCategoryNames()) {
            elements.add(new ConfigElement(cfg.getCategory(name)));
        }
        return elements;
    }
}
