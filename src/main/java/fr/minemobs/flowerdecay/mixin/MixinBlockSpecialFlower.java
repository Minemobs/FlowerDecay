package fr.minemobs.flowerdecay.mixin;

import fr.minemobs.flowerdecay.access.BlockSpecialAccess;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.botania.common.block.BlockSpecialFlower;

@Mixin(BlockSpecialFlower.class)
public class MixinBlockSpecialFlower implements BlockSpecialAccess {

    private PlayerEntity placer;

    @Inject(method = "onBlockPlacedBy", at = @At("HEAD"))
    public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack, CallbackInfo ci) {
        if(entity instanceof PlayerEntity) {
            placer = (PlayerEntity) entity;
        }
    }

    @Override
    public PlayerEntity playerEntity() {
        return placer;
    }
}