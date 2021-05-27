package fr.minemobs.flowerdecay.mixin;

import fr.minemobs.flowerdecay.FlowerDecay;
import fr.minemobs.flowerdecay.StatsInit;
import fr.minemobs.flowerdecay.access.BlockSpecialAccess;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.botania.api.subtile.TileEntityGeneratingFlower;
import vazkii.botania.api.subtile.TileEntitySpecialFlower;
import vazkii.botania.common.block.BlockSpecialFlower;

@Mixin(value = TileEntityGeneratingFlower.class, remap = false)
public abstract class MixinTileEntityGeneratingFlower extends TileEntitySpecialFlower {

    public MixinTileEntityGeneratingFlower(TileEntityType<?> type) {
        super(type);
    }

    /**
     * Link : {@link vazkii.botania.common.block.subtile.generating.SubTileEndoflame#addMana(int) endoflame}
     * It's a bit broken so i'm gonna rework on it tomorrow
     * @author minemobs
     */

    @Inject(method = "addMana", at = @At("TAIL"))
    public void addMana(int mana, CallbackInfo ci) {
        if(mana > 0) {
            BlockSpecialFlower block = (BlockSpecialFlower) this.getBlockState().getBlock();
            FlowerDecay.LOGGER.info(increaseStat(((BlockSpecialAccess) block).playerEntity(), mana));
        }
    }

    private int increaseStat(PlayerEntity player, int value) {
        if(player == null || player.getEntityWorld().isRemote || !(player instanceof ServerPlayerEntity)) return 0;
        int currentValue = ((ServerPlayerEntity) player).getStats().getValue(Stats.CUSTOM.get(StatsInit.MANA_GENERATED));
        player.addStat(StatsInit.MANA_GENERATED, value);
        return currentValue;
    }
}
