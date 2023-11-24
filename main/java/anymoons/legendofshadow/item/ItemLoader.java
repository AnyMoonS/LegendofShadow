package anymoons.legendofshadow.item;

import anymoons.legendofshadow.item.attack.BloodGiantSword;
import anymoons.legendofshadow.item.attack.ShadowKnife;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = "legendofshadow")
public final class ItemLoader
{
    public static final CreativeTabs LEGENDOFSHADOW_TAB = new CreativeTabs("legendofshadow_tab") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ItemLoader.goldsoul);
        }
    };

    public static Item ironsoul;
    public static Item goldsoul;
    public static Item coppersoul;
    public static Item whatami;
    public static Item shadowapple;
    public static Item shadowbloodingot;
    public static Item etheringot;
    public static Item shadowknife;
    public static Item shadowpickaxe;
    public static Item bloodstick;
    public static Item soulstick;
    public static Item coagulationingot;
    public static Item shadowingot;
    public static Item bloodbow;
    public static Item bloodgiantsword;
    public static Item etherapple;
    public static Item etherpickaxe;
    public static Item shadowcore;

    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event)
    {
//-------------------------------------------------Item-------------------------------------------------------
        event.getRegistry().registerAll(
                        ironsoul = new Item() //铁之精魄
                                .setCreativeTab(LEGENDOFSHADOW_TAB)
                                .setRegistryName("legendofshadow:ironsoul")
                                .setUnlocalizedName("legendofshadow.ironsoul")
                                .setMaxStackSize(64),

                        goldsoul = new Item()
                                .setCreativeTab(LEGENDOFSHADOW_TAB)
                                .setRegistryName("legendofshadow:goldsoul")
                                .setUnlocalizedName("legendofshadow.goldsoul")
                                .setMaxStackSize(64),

                        coppersoul = new Item()
                                .setCreativeTab(LEGENDOFSHADOW_TAB)
                                .setRegistryName("legendofshadow:coppersoul")
                                .setUnlocalizedName("legendofshadow.coppersoul")
                                .setMaxStackSize(64),

                        whatami = new Item()
                                .setCreativeTab(LEGENDOFSHADOW_TAB)
                                .setRegistryName("legendofshadow:whatami")
                                .setUnlocalizedName("legendofshadow.whatami")
                                .setMaxStackSize(1),

                        shadowbloodingot = new Item()
                                .setCreativeTab(LEGENDOFSHADOW_TAB)
                                .setRegistryName("legendofshadow:shadowbloodingot")
                                .setUnlocalizedName("legendofshadow.shadowbloodingot")
                                .setMaxStackSize(64),

                        etheringot = new Item()
                                .setCreativeTab(LEGENDOFSHADOW_TAB)
                                .setRegistryName("legendofshadow:etheringot")
                                .setUnlocalizedName("legendofshadow.etheringot")
                                .setMaxStackSize(64),

                        bloodstick = new Item()
                                .setCreativeTab(LEGENDOFSHADOW_TAB)
                                .setRegistryName("legendofshadow:bloodstick")
                                .setUnlocalizedName("legendofshadow.bloodstick")
                                .setMaxStackSize(64),

                        soulstick = new Item()
                                .setCreativeTab(LEGENDOFSHADOW_TAB)
                                .setRegistryName("legendofshadow:soulstick")
                                .setUnlocalizedName("legendofshadow.soulstick")
                                .setMaxStackSize(64),

                        coagulationingot = new Item()
                                .setCreativeTab(LEGENDOFSHADOW_TAB)
                                .setRegistryName("legendofshadow:coagulationingot")
                                .setUnlocalizedName("legendofshadow.coagulationingot")
                                .setMaxStackSize(64),

                        shadowingot = new Item()
                                .setCreativeTab(LEGENDOFSHADOW_TAB)
                                .setRegistryName("legendofshadow:shadowingot")
                                .setUnlocalizedName("legendofshadow.shadowingot")
                                .setMaxStackSize(64),

                        shadowcore = new Item()
                                .setCreativeTab(LEGENDOFSHADOW_TAB)
                                .setRegistryName("legendofshadow:shadowcore")
                                .setUnlocalizedName("legendofshadow.shadowcore")
                                .setMaxStackSize(64),

//-------------------------------------------------Food-------------------------------------------------------

                        shadowapple = new FoodLoader(10,10)
                                .setCreativeTab(LEGENDOFSHADOW_TAB)
                                .setRegistryName("legendofshadow:shadowapple")
                                .setUnlocalizedName("legendofshadow.shadowapple")
                                .setMaxStackSize(64),

                        etherapple = new FoodLoader(10,10)
                                .setCreativeTab(LEGENDOFSHADOW_TAB)
                                .setRegistryName("legendofshadow:etherapple")
                                .setUnlocalizedName("legendofshadow.etherapple")
                                .setMaxStackSize(64),
//-------------------------------------------------Tool-------------------------------------------------------

                        shadowknife = new ShadowKnife(Material.SHADOWKNIFE)
                                .setCreativeTab(LEGENDOFSHADOW_TAB)
                                .setRegistryName("legendofshadow:shadowknife")
                                .setUnlocalizedName("legendofshadow.shadowknife")
                                .setMaxStackSize(1),

                        shadowpickaxe = new PickaxeLoader(Material.SHADOWPICKAXE)
                                .setCreativeTab(LEGENDOFSHADOW_TAB)
                                .setRegistryName("legendofshadow:shadowpickaxe")
                                .setUnlocalizedName("legendofshadow.shadowpickaxe")
                                .setMaxStackSize(1),

                        bloodbow = new BowLoader()
                                .setCreativeTab(LEGENDOFSHADOW_TAB)
                                .setRegistryName("legendofshadow:bloodbow")
                                .setUnlocalizedName("legendofshadow.bloodbow")
                                .setMaxStackSize(1),

                        bloodgiantsword = new BloodGiantSword(Material.BLOODGIANTSWORD)
                                .setCreativeTab(LEGENDOFSHADOW_TAB)
                                .setRegistryName("legendofshadow:bloodgiantsword")
                                .setUnlocalizedName("legendofshadow.bloodgiantsword")
                                .setMaxStackSize(1),

                        etherpickaxe = new PickaxeLoader(Material.ETHERPICKAXE)
                                .setCreativeTab(LEGENDOFSHADOW_TAB)
                                .setRegistryName("legendofshadow:etherpickaxe")
                                .setUnlocalizedName("legendofshadow.etherpickaxe")
                                .setMaxStackSize(1)


//-------------------------------------------------Armor-------------------------------------------------------
        );
    }
}