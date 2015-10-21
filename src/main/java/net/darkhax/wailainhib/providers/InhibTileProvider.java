package net.darkhax.wailainhib.providers;

import java.util.List;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaRegistrar;
import net.darkhax.wailainhib.handler.ConfigurationHandler;
import net.darkhax.wailainhib.util.Utilities;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class InhibTileProvider implements IWailaDataProvider {
    
    @Override
    public ItemStack getWailaStack (IWailaDataAccessor data, IWailaConfigHandler cfg) {
        
        Block fakeBlock = null;
        
        if (data.getPlayer().isPotionActive(Potion.confusion))
            fakeBlock = Block.getBlockFromName(ConfigurationHandler.fakeBlocks[Utilities.RND.nextInt(ConfigurationHandler.fakeBlocks.length)]);
            
        return fakeBlock != null ? new ItemStack(fakeBlock) : data.getStack();
    }
    
    @Override
    public List<String> getWailaHead (ItemStack stack, List<String> tip, IWailaDataAccessor data, IWailaConfigHandler cfg) {
        
        return tip;
    }
    
    @Override
    public List<String> getWailaBody (ItemStack stack, List<String> tip, IWailaDataAccessor data, IWailaConfigHandler cfg) {
        
        return tip;
    }
    
    @Override
    public List<String> getWailaTail (ItemStack stack, List<String> tip, IWailaDataAccessor data, IWailaConfigHandler cfg) {
        
        return tip;
    }
    
    @Override
    public NBTTagCompound getNBTData (EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, int x, int y, int z) {
        
        return tag;
    }
    
    public static void registerAddon (IWailaRegistrar register) {
        
        InhibTileProvider dataProvider = new InhibTileProvider();
        register.registerStackProvider(dataProvider, Block.class);
    }
}
