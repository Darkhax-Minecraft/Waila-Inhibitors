package net.darkhax.wailainhib.client;

import net.darkhax.wailainhib.client.rendering.WailaRenderingHandler;
import net.darkhax.wailainhib.common.CommonProxy;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {
    
    @Override
    public void preInit () {
        
        MinecraftForge.EVENT_BUS.register(new WailaRenderingHandler());
    }
}
