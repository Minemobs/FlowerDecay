package fr.minemobs.flowerdecay.mixin;

import fr.minemobs.flowerdecay.config.DecayConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.botania.api.subtile.TileEntitySpecialFlower;
import vazkii.botania.common.block.BlockSpecialFlower;

import java.util.function.Supplier;

@Mixin(BlockSpecialFlower.class)
public abstract class MixinBlockSpecialFlower {

    @Shadow(remap = false) @Final private Supplier<? extends TileEntitySpecialFlower> teProvider;
    private PlayerEntity placer;

    @Inject(method = "onBlockPlacedBy", at = @At("HEAD"))
    public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack, CallbackInfo ci) {
        if(entity instanceof PlayerEntity) {
            placer = (PlayerEntity) entity;
        }
    }
}
