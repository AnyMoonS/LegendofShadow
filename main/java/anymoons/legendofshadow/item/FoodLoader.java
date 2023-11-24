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
        if (!player.world.isRemote) {
            NBTTagCompound playerData = player.getEntityData();
            if (!itemStack.isEmpty() && itemStack.getItem() == ItemLoader.shadowapple) {
                int shadowHeartValue = playerData.getInteger("ShadowHeart");
                shadowHeartValue += 5;
                playerData.setInteger("ShadowHeart", shadowHeartValue);
                player.sendMessage(new TextComponentString("杂乱的呓语在耳边萦绕不绝"));
            }
            if (!itemStack.isEmpty() && itemStack.getItem() == ItemLoader.etherapple) {
                int soulHeartValue = playerData.getInteger("SoulHeart");
                soulHeartValue += 5;
                playerData.setInteger("SoulHeart", soulHeartValue);
                player.sendMessage(new TextComponentString("你感受了灵魂深处的回响"));
            }
        }
    }
}
