package fr.minemobs.flowerdecay.mixin;

import fr.minemobs.flowerdecay.config.DecayConfig;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.botania.api.subtile.TileEntitySpecialFlower;

@Mixin(value = TileEntitySpecialFlower.class)
public abstract class MixinTileEntitySpecialFlower extends TileEntity {

    @Shadow(remap = false) public int ticksExisted;

    public MixinTileEntitySpecialFlower(TileEntityType<?> type) {
        super(type);
    }

    @Inject(method = "tick", at = @At("HEAD"))
    public void tick(CallbackInfo ci) {
        if(ticksExisted == DecayConfig.ticks.get()) {
            this.world.setBlockState(this.getPos(), Blocks.DEAD_BUSH.getDefaultState());
        }
    }
}
