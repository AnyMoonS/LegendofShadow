package anymoons.legendofshadow.item.block;

import anymoons.legendofshadow.item.ItemLoader;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.items.ItemStackHandler;

public class ElementalRefinerTileEntity extends TileEntity {
    private ItemStackHandler inputInventory = new ItemStackHandler(1); // 输入物品槽
    private ItemStackHandler outputInventory = new ItemStackHandler(1); // 输出物品槽
    // 在这里处理物品的处理逻辑

    // 例如，处理输入并生成输出的方法
    private void processItems() {
        ItemStack inputStack = inputInventory.getStackInSlot(0);
        if (!inputStack.isEmpty()) {
            // 处理输入物品逻辑，生成输出物品
            ItemStack outputStack = new ItemStack(ItemLoader.etheringot);
            outputInventory.setStackInSlot(0, outputStack);
            inputInventory.extractItem(0, 1, false);
            markDirty(); // 通知游戏保存TileEntity的状态
        }
    }
}
