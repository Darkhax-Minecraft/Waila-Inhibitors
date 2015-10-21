package net.darkhax.wailainhib.client.rendering;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.darkhax.wailaevents.event.WailaRenderEvent;
import net.darkhax.wailainhib.handler.ConfigurationHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;

public class WailaRenderingHandler {
    
    ConfigurationHandler config;
    
    @SubscribeEvent
    public void onWailaPreRender (WailaRenderEvent.Pre event) {
        
        EntityPlayer player = Minecraft.func_71410_x().field_71439_g;
        int light = Utilities.getBlockLightLevel(player.field_70170_p, (int) player.field_70165_t, (int) (player.field_70163_u + player.func_70047_e()), (int) player.field_70161_v, false);
        
        if ((ConfigurationHandler.factorBlindness) && (player.func_70644_a(Potion.field_76440_q))) {
            event.setCanceled(true);
        }
        
        if ((ConfigurationHandler.factorDaylight) && (Utilities.isPlayerInSun(player)) && (!Utilities.canPlayerSleep(player))) {
            return;
        }
        
        if ((ConfigurationHandler.factorDarkness) && (Utilities.getBlockLightLevel(player.field_70170_p, (int) player.field_70165_t, (int) (player.field_70163_u + player.func_70047_e()), (int) player.field_70161_v, false) < ConfigurationHandler.lightThreshold)) {
            event.setCanceled(true);
        }
    }
}
