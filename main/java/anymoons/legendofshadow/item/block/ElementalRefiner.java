package anymoons.legendofshadow.item.block;

import anymoons.legendofshadow.item.ItemLoader;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;


public class ElementalRefiner extends BlockContainer {
    public ElementalRefiner(){
        super(Material.ROCK);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new ElementalRefinerTileEntity();
    }
}
