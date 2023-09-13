package anymoons.legendofshadow.item;

import anymoons.legendofshadow.player.PlayerProperties;
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
    public void onFoodEaten(ItemStack itemStack, World worldIn, EntityPlayer Player) {
        if (Player.world.isRemote) {
            EntityPlayer player = Player;
            ItemStack heldItem = itemStack;
            NBTTagCompound playerData = player.getEntityData();
            if (!heldItem.isEmpty() && heldItem.getItem() == ItemLoader.shadowapple) {
                player.sendMessage(new TextComponentString("你感到有什么在你的耳边低语，"));
                PlayerProperties.setShadowHeart(5);
                PlayerProperties.writeToShadowHeart(playerData);
            }
        }
    }

    @SubscribeEvent
    public void EatShadowApple(LivingEntityUseItemEvent.Finish event) {
        ItemStack usedItem = event.getItem();
        onFoodEaten(usedItem,event.getEntity().world, (EntityPlayer) event.getEntity());
    }
}
