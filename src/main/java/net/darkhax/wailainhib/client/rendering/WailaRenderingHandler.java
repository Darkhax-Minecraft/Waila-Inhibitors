package net.darkhax.wailainhib.client.rendering;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.darkhax.wailaevents.event.WailaRenderEvent;
import net.darkhax.wailainhib.handler.ConfigurationHandler;
import net.darkhax.wailainhib.util.Utilities;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;

public class WailaRenderingHandler {
    
    @SubscribeEvent
    public void onWailaPreRender (WailaRenderEvent.Pre event) {
        
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        
        if ((ConfigurationHandler.factorBlindness) && (player.isPotionActive(Potion.blindness)))
            event.setCanceled(true);
            
        if ((ConfigurationHandler.factorDaylight) && (Utilities.isPlayerInSun(player)) && (!Utilities.canPlayerSleep(player)))
            return;
            
        if ((ConfigurationHandler.factorDarkness)) {
            
            // TODO fix light code
        }
    }
}
