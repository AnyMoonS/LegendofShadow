package anymoons.legendofshadow.events;
import anymoons.legendofshadow.item.ItemLoader;
import anymoons.legendofshadow.player.PlayerProperties;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


@Mod.EventBusSubscriber(modid = "legendofshadow")
public class EventsLoader {

    private static int enemiesHit = 0;

    public EventsLoader() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void PickupShadowKnife(EntityItemPickupEvent event) { // 拾取影血短匕
        EntityPlayer player = event.getEntityPlayer();
        ItemStack pickedItem = event.getItem().getItem();
        Item item = pickedItem.getItem();
        if (item == Item.getByNameOrId("legendofshadow:shadowknife")) {
            if (!player.world.isRemote) {
                player.attackEntityFrom(DamageSource.GENERIC, 2.0f);
                player.sendMessage(new TextComponentString("你感到有些疲倦"));
            }
        }
    }
    @SubscribeEvent
    public static void UseWhatamI(PlayerInteractEvent.RightClickItem event) { // 右键自我窥视之镜
        EntityPlayer player = event.getEntityPlayer();
        if(!player.world.isRemote) {
            ItemStack heldItem = player.getHeldItemMainhand();
            if (!heldItem.isEmpty() && heldItem.getItem() == ItemLoader.whatami) {
                int ShadowHeart = PlayerProperties.ShadowHeart;
                int SoulHeart = PlayerProperties.SoulHeart;
                String ShadowHeartMessage = "你的浸影值为 " + ShadowHeart;
                String SoulHeartMessage = "你的趋光值为 " + SoulHeart;
                player.sendMessage(new TextComponentString(ShadowHeartMessage));
                player.sendMessage(new TextComponentString(SoulHeartMessage));
            }
        }
    }

    @SubscribeEvent
    public static void BloodGiantSwordAttack(LivingAttackEvent event) {
        EntityLivingBase target = event.getEntityLiving();
        EntityLivingBase attacker = (EntityLivingBase) event.getSource().getTrueSource();
        EntityPlayer player = (EntityPlayer) attacker;
        if (attacker instanceof EntityPlayer) {
            ItemStack heldItem = player.getHeldItemMainhand();
            if (!heldItem.isEmpty() && heldItem.getItem() == ItemLoader.bloodgiantsword) {
                if (target instanceof EntityLivingBase && !(target instanceof EntityPlayer)) {
                    double range = 3.0;
                    for (Entity nearbyEntity : target.world.getEntitiesWithinAABB(Entity.class, target.getEntityBoundingBox().grow(range))) {
                        if (nearbyEntity instanceof EntityLivingBase && nearbyEntity != target && nearbyEntity != player) {
                            EntityLivingBase nearbyLiving = (EntityLivingBase) nearbyEntity;
                            float extraDamage = 20.0F; // 对周围的额外伤害
                            nearbyLiving.attackEntityFrom(DamageSource.FALL, extraDamage);
                        }
                        enemiesHit++;
                    }
                }
            }
        }
    }


    @SubscribeEvent
    public static void Enemies(LivingHurtEvent event) {
        EntityLivingBase attacker = (EntityLivingBase) event.getSource().getTrueSource();
        // 检查事件是否涉及到玩家
        if (attacker instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) attacker;
            if (!player.world.isRemote) {
                ItemStack heldItem = player.getHeldItemMainhand();
                if (!heldItem.isEmpty() && heldItem.getItem() == ItemLoader.bloodgiantsword) {
                    player.attackEntityFrom(DamageSource.GENERIC, 6.0f);
                    enemiesHit = (enemiesHit - 2) / 2; // 存在击中数量的严重BUG，未来修复
                    String test = enemiesHit + "个";
                    float healingAmount = enemiesHit * 2.0F; // 以命中的敌人数量乘以系数作为回复生命值的示例
                    player.heal(healingAmount);
                    player.sendMessage(new TextComponentString(test));
                    enemiesHit = 0;
                }
            }
        }
    }
}