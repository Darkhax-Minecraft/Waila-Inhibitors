package net.darkhax.wailainhib.client.rendering;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.darkhax.wailaevents.event.WailaRenderEvent;
import net.darkhax.wailainhib.handler.ConfigurationHandler;
import net.darkhax.wailainhib.util.Utilities;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;

public class WailaRenderingHandler {
    
    @SubscribeEvent
    public void onWailaPreRender (WailaRenderEvent.Pre event) {
        
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        int goodX = MathHelper.floor_double(player.posX);
        int goodY = MathHelper.floor_double(player.posY);
        int goodZ = MathHelper.floor_double(player.posZ);
        
        if ((ConfigurationHandler.factorBlindness) && (player.isPotionActive(Potion.blindness)))
            event.setCanceled(true);
            
        if ((ConfigurationHandler.factorDaylight) && Utilities.isPlayerInSun(player.worldObj, goodX, goodY, goodZ) && (!Utilities.canPlayerSleep(player)))
            return;
            
        if ((ConfigurationHandler.factorDarkness)) {
            
            if (goodY > 0 && goodY < 256 && Utilities.getBlockLightLevel(player.worldObj, goodX, goodY, goodZ, false) < ConfigurationHandler.lightThreshold)
                event.setCanceled(true);
        }
    }
}
