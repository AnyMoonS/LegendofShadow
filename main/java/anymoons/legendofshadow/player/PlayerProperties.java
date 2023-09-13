package anymoons.legendofshadow.player;

import net.minecraft.advancements.critereon.NBTPredicate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "legendofshadow")
public class PlayerProperties {
    public static int ShadowHeart = 0;

    public static int getShadowHeart() {
        return ShadowHeart;
    }

    public static void setShadowHeart(int value) {
        ShadowHeart = value;
    }

    public static void addShadowHeart(int value) {
        ShadowHeart = ShadowHeart + value;
    }

    public static void writeToShadowHeart(NBTTagCompound compound) {
        compound.setInteger("ShadowHeart", ShadowHeart);
    }

    public static void readToShadow(NBTTagCompound compound) {
        compound.getInteger("ShadowHeart");
    }

}
