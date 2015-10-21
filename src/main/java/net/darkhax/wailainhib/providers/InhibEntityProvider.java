package net.darkhax.wailainhib.providers;

import java.util.List;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaEntityAccessor;
import mcp.mobius.waila.api.IWailaEntityProvider;
import mcp.mobius.waila.api.IWailaRegistrar;
import net.darkhax.wailainhib.handler.ConfigurationHandler;
import net.darkhax.wailainhib.util.Utilities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

public class InhibEntityProvider implements IWailaEntityProvider {
    
    @Override
    public Entity getWailaOverride (IWailaEntityAccessor data, IWailaConfigHandler cfg) {
        
        Entity fakeMob = null;
        
        if (data.getPlayer().isPotionActive(Potion.confusion))
            fakeMob = EntityList.createEntityByName(ConfigurationHandler.fakeMobs[Utilities.RND.nextInt(ConfigurationHandler.fakeMobs.length)], data.getWorld());
            
        return fakeMob != null ? fakeMob : data.getEntity();
    }
    
    @Override
    public List<String> getWailaHead (Entity entity, List<String> tip, IWailaEntityAccessor data, IWailaConfigHandler cfg) {
        
        return tip;
    }
    
    @Override
    public List<String> getWailaBody (Entity entity, List<String> tip, IWailaEntityAccessor data, IWailaConfigHandler cfg) {
        
        return tip;
    }
    
    @Override
    public List<String> getWailaTail (Entity entity, List<String> tip, IWailaEntityAccessor data, IWailaConfigHandler cfg) {
        
        return tip;
    }
    
    @Override
    public NBTTagCompound getNBTData (EntityPlayerMP player, Entity entity, NBTTagCompound tag, World world) {
        
        return tag;
    }
    
    public static void registerAddon (IWailaRegistrar register) {
        
        InhibEntityProvider dataProvider = new InhibEntityProvider();
        register.registerOverrideEntityProvider(dataProvider, Entity.class);
    }
}
