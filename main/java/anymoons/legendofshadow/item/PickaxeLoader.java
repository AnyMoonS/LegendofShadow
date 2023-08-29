package anymoons.legendofshadow.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "legendofshadow")
public class PickaxeLoader extends ItemPickaxe {

    public PickaxeLoader(Item.ToolMaterial material) {
        super(material);

    }
}
