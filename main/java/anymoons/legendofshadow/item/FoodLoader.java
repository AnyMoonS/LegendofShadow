package anymoons.legendofshadow.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FoodLoader extends ItemFood {
    public FoodLoader(int healAmount, float saturation) {

        super(healAmount, saturation, false);
    }

    @Override
    public void onFoodEaten(ItemStack itemStack, World worldIn, EntityPlayer player) {
        if (player.world.isRemote) {
            NBTTagCompound playerData = player.getEntityData();
            if (!itemStack.isEmpty() && itemStack.getItem() == ItemLoader.shadowapple) {
                playerData.setInteger("ShadowHeart", 5);
                player.sendMessage(new TextComponentString("你感到有什么在你的耳边低语"));
                // int ShadowHeartValue = playerData.getInteger("ShadowHeart");
                // ShadowHeartValue += 5;
            }
        }
    }
}
