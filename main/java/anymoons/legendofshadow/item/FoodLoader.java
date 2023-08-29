package anymoons.legendofshadow.item;

import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "legendofshadow")
public final class FoodLoader extends ItemFood{
    public FoodLoader(int healAmount,float saturation) {
        super(healAmount, saturation, false);
    }
}
