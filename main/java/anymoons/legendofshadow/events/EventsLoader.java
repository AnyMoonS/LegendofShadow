package anymoons.legendofshadow.events;

import anymoons.legendofshadow.item.ItemLoader;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextComponentScore;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;


@Mod.EventBusSubscriber(modid = "legendofshadow")
public class EventsLoader {

    public EventsLoader() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) { //玩家加入创建NBT
        EntityPlayer player = event.player;
        NBTTagCompound playerNBT = player.getEntityData();
        if (!player.world.isRemote) {
            // 检查是否已经有自定义的NBT值
            if (!playerNBT.hasKey("ShadowHeart")) {
                playerNBT.setTag("ShadowHeart", new NBTTagCompound());
                // 赋予初始值
                playerNBT.setInteger("ShadowHeart", 0);
            }
            if (!playerNBT.hasKey("SoulHeart")) {
                playerNBT.setTag("SoulHeart", new NBTTagCompound());
                // 赋予初始值
                playerNBT.setInteger("SoulHeart", 0);
            }
        }
    }

    private static int shadowHeartD;
    private static int soulHeartD;

    @SubscribeEvent
    public static void onPlayerDeath(LivingDeathEvent event) { //玩家死亡继承NBT
        if (event.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntity();
            NBTTagCompound playerData = player.getEntityData();
            if (!player.world.isRemote) {
                if (!playerData.hasKey("ShadowHeartD")) {
                    playerData.setTag("ShadowHeartD", new NBTTagCompound());
                }
                if (!playerData.hasKey("SoulHeartD")) {
                    playerData.setTag("SoulHeartD", new NBTTagCompound());
                }
                // 在这里保存你想要保留的NBT数据
                int ShadowHeartValue = playerData.getInteger("ShadowHeart");
                int SoulHeartValue = playerData.getInteger("SoulHeart");
                shadowHeartD = ShadowHeartValue;
                soulHeartD = SoulHeartValue;
                player.sendMessage(new TextComponentString("玩家已死亡"));
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) { //玩家重生继承NBT
        EntityPlayer player = event.player;
        NBTTagCompound playerData = player.getEntityData();
        if (!player.world.isRemote) {
            // 在这里恢复你保存的NBT数据
            int ShadowHeartValue = shadowHeartD;
            int SoulHeartValue = soulHeartD;
            playerData.setInteger("ShadowHeart", ShadowHeartValue);
            playerData.setInteger("SoulHeart", SoulHeartValue);
            player.sendMessage(new TextComponentString("玩家已复活"));
        }
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
        NBTTagCompound playerNBT = player.getEntityData();
        if (!player.world.isRemote) {
            ItemStack heldItem = player.getHeldItemMainhand();
            if (!heldItem.isEmpty() && heldItem.getItem() == ItemLoader.whatami) {
                int shadowHeartValue = playerNBT.getInteger("ShadowHeart");
                int soulHeartValue = playerNBT.getInteger("SoulHeart");
                String shadowHeartMessage = "你的浸影值为 " + shadowHeartValue;
                String soulHeartMessage = "你的趋光值为 " + soulHeartValue;
                player.sendMessage(new TextComponentString(shadowHeartMessage));
                player.sendMessage(new TextComponentString(soulHeartMessage));
            }
        }
    }

    private static int BGSenemiesHit = 0;

    @SubscribeEvent
    public static void BloodGiantSwordAttack(LivingAttackEvent event) { //渴血巨剑额外伤害判定
        EntityLivingBase target = event.getEntityLiving();
        EntityLivingBase attacker = (EntityLivingBase) event.getSource().getTrueSource();
        EntityPlayer player = (EntityPlayer) attacker;
        if (attacker != null) {
            ItemStack heldItem = player.getHeldItemMainhand();
            if (!heldItem.isEmpty() && heldItem.getItem() == ItemLoader.bloodgiantsword) {
                if (target != null && !(target instanceof EntityPlayer)) {
                    double range = 3.0;
                    for (Entity nearbyEntity : target.world.getEntitiesWithinAABB(Entity.class, target.getEntityBoundingBox().grow(range))) {
                        if (nearbyEntity instanceof EntityLivingBase && nearbyEntity != target && nearbyEntity != player) {
                            EntityLivingBase nearbyLiving = (EntityLivingBase) nearbyEntity;
                            float extraDamage = 10.0F; // 对周围的额外伤害
                            nearbyLiving.attackEntityFrom(DamageSource.FALL, extraDamage);
                        }
                        BGSenemiesHit++;
                    }
                }
            }
        }
    }


    @SubscribeEvent
    public static void BloodGiantSwordHeal(LivingHurtEvent event) { //渴血巨剑吸血效果判定
        EntityLivingBase attacker = (EntityLivingBase) event.getSource().getTrueSource();
        if (attacker instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) attacker;
            if (!player.world.isRemote) {
                NBTTagCompound playerNBT = player.getEntityData();
                int shadowHeartValue = playerNBT.getInteger("ShadowHeart");
                ItemStack heldItem = player.getHeldItemMainhand();
                if (!heldItem.isEmpty() && heldItem.getItem() == ItemLoader.bloodgiantsword) {
                    if (shadowHeartValue < 20) {
                        player.attackEntityFrom(DamageSource.GENERIC, 666.0f);
                        player.sendMessage(new TextComponentString("手中的巨剑恍若有了生命，呢喃道，你仍不够格"));
                    }
                    if (shadowHeartValue < 30 && shadowHeartValue >= 20) {
                        player.attackEntityFrom(DamageSource.GENERIC, 6.0f);
                    }
                    BGSenemiesHit = (BGSenemiesHit - 2) / 2; // 你问我为什么是这个算法？我也不知道，但他就是正确率高
                    String test = BGSenemiesHit + "个";
                    float healingAmount = BGSenemiesHit * 2.0F; // 以命中的敌人数量乘以系数作为回复生命值
                    player.heal(healingAmount);
                    player.sendMessage(new TextComponentString(test));
                    BGSenemiesHit = 0;
                }
            }
        }
    }


}