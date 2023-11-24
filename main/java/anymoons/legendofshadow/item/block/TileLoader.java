package anymoons.legendofshadow.item.block;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileLoader {
    public static ResourceLocation ElementalRefinerTileEntity = new ResourceLocation("legendofshadow:elementalrefinertileentity");
    public static void registerTileEntity(){
        GameRegistry.registerTileEntity(anymoons.legendofshadow.item.block.ElementalRefinerTileEntity.class, ElementalRefinerTileEntity);

    }
}
