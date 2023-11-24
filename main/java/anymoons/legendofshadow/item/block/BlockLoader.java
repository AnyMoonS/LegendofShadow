package anymoons.legendofshadow.item.block;

import anymoons.legendofshadow.item.ItemLoader;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockLoader {
    public static Block elementalRefiner;
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event){
        event.getRegistry().registerAll(
                elementalRefiner = new ElementalRefiner()
                        .setCreativeTab(ItemLoader.LEGENDOFSHADOW_TAB)
                        .setRegistryName("legendofshadow:elementalrefiner")
                        .setUnlocalizedName("legendofshadow.elementalrefiner")
        );
    }
}
