package anymoons.legendofshadow.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class Material {
    public static final Item.ToolMaterial SHADOWKNIFE = EnumHelper.addToolMaterial("SHADOWKNIFE",1,100,1.0f,1.0f,30)
            .setRepairItem(new ItemStack(ItemLoader.shadowbloodingot));
    public static final Item.ToolMaterial SHADOWPICKAXE = EnumHelper.addToolMaterial("SHADOWPICKAXE",4,100,10.0f,1.0f,30)
            .setRepairItem(new ItemStack(ItemLoader.shadowbloodingot));
    public static final Item.ToolMaterial BLOODGIANTSWORD = EnumHelper.addToolMaterial("BLOODGIANTSWORD",1,100,10.0f,1.0f,30)
            .setRepairItem(new ItemStack(ItemLoader.coagulationingot));
}
