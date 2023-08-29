package anymoons.legendofshadow.item.attack;

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;
import net.minecraftforge.fml.common.Mod;

import java.util.Set;

@Mod.EventBusSubscriber(modid = "legendofshadow")
public class ShadowKnife extends ItemTool {

    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.AIR);

    public ShadowKnife(Item.ToolMaterial material) {
        super(3.0F,-1.0F,material,EFFECTIVE_ON); // 攻击伤害 = 2.0 + attackDamageIn
    }
}
