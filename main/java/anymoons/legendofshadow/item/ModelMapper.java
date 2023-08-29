package anymoons.legendofshadow.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = Side.CLIENT,modid = "legendofshadow")
public final class ModelMapper {
    @SubscribeEvent
    public static void onModelReg(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(
                ItemLoader.ironsoul,0,new ModelResourceLocation(ItemLoader.ironsoul.getRegistryName(),"inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                ItemLoader.goldsoul,0,new ModelResourceLocation(ItemLoader.goldsoul.getRegistryName(),"inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                ItemLoader.coppersoul,0,new ModelResourceLocation(ItemLoader.coppersoul.getRegistryName(),"inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                ItemLoader.whatami,0,new ModelResourceLocation(ItemLoader.whatami.getRegistryName(),"inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                ItemLoader.shadowapple,0,new ModelResourceLocation(ItemLoader.shadowapple.getRegistryName(),"inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                ItemLoader.shadowbloodingot,0,new ModelResourceLocation(ItemLoader.shadowbloodingot.getRegistryName(),"inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                ItemLoader.etheringot,0,new ModelResourceLocation(ItemLoader.etheringot.getRegistryName(),"inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                ItemLoader.shadowknife,0,new ModelResourceLocation(ItemLoader.shadowknife.getRegistryName(),"inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                ItemLoader.shadowpickaxe,0,new ModelResourceLocation(ItemLoader.shadowpickaxe.getRegistryName(),"inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                ItemLoader.bloodstick,0,new ModelResourceLocation(ItemLoader.bloodstick.getRegistryName(),"inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                ItemLoader.soulstick,0,new ModelResourceLocation(ItemLoader.soulstick.getRegistryName(),"inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                ItemLoader.coagulationingot,0,new ModelResourceLocation(ItemLoader.coagulationingot.getRegistryName(),"inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                ItemLoader.shadowingot,0,new ModelResourceLocation(ItemLoader.shadowingot.getRegistryName(),"inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                ItemLoader.bloodbow,0,new ModelResourceLocation(ItemLoader.bloodbow.getRegistryName(),"inventory")
        );
    }
}
