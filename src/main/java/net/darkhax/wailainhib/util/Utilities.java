package net.darkhax.wailainhib.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class Utilities {
    
    public static int getBlockLightLevel (World world, int x, int y, int z, boolean day) {
        
        return day ? world.func_72964_e(x >> 4, z >> 4).func_76629_c(x & 0xF, y + 1, z & 0xF, 0) : world.func_72964_e(x >> 4, z >> 4).func_76629_c(x & 0xF, y + 1, z & 0xF, 16);
    }
    
    public static boolean canPlayerSleep (EntityPlayer player) {
        
        return (!player.func_70608_bn()) && (player.func_70089_S()) && (player.field_70170_p.func_72820_D() > 12541L) && (player.field_70170_p.func_72820_D() < 23458L);
    }
    
    public static boolean isPlayerInSun (EntityPlayer player) {
        
        boolean isSkylight = true;
        for (int y = (int) player.field_70163_u; y < 257; y++) {
            isSkylight = player.field_70170_p.func_147437_c((int) player.field_70165_t, y, (int) player.field_70161_v);
            if (!isSkylight) {
                break;
            }
        }
        return isSkylight;
    }
}
