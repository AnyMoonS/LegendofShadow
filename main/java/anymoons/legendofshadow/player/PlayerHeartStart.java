package anymoons.legendofshadow.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

@Mod.EventBusSubscriber(modid = "legendofshadow")
public class PlayerHeartStart {

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        EntityPlayer player = event.player;
        NBTTagCompound playerData = player.getEntityData();
        if (!playerData.hasKey("ShadowHeart")) {
            playerData.setTag("ShadowHeart", new NBTTagCompound());
            PlayerProperties.getShadowHeart();
            PlayerProperties.setShadowHeart(0);
            PlayerProperties.writeToShadowHeart(playerData);
        }
    }
}
