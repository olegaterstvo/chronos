package net.chronos.chronosproject.effect;

import com.mojang.blaze3d.vertex.PoseStack;
import net.chronos.chronosproject.event.ModEvents;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.EffectRenderer;

import java.util.Random;
import java.util.function.Consumer;

public class ParanoiaEffect extends MobEffect {
    private static final int ticks = 100;
    private int i = 0;
    private int random = -1;
    private int randBlock = -1;
    private boolean shouldRender = Boolean.TRUE;

    public ParanoiaEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    private void setFire(LivingEntity pLivingEntity){
        if (pLivingEntity.level.isClientSide()) {
            pLivingEntity.setRemainingFireTicks(1);
//            pLivingEntity.setSharedFlagOnFire(Boolean.TRUE);
            if (Math.floorMod(i, 40) == 0) {
                pLivingEntity.animateHurt();
                pLivingEntity.playSound(SoundEvents.PLAYER_HURT_ON_FIRE, 1, 1);
            }
        }
    }

    private void setSwim(LivingEntity pLivingEntity){
        if (pLivingEntity.level.isClientSide()) {
            pLivingEntity.setSwimming(Boolean.TRUE);
            if (Math.floorMod(i, 40) == 0) {
//                pLivingEntity.playSound(SoundEvents.PLAYER_HURT_DROWN, 1, 1);
                pLivingEntity.playSound(SoundEvents.AMBIENT_UNDERWATER_LOOP, 2, 1);
            }
        }
    }
    private void setHurt(LivingEntity pLivingEntity){
        if (pLivingEntity.level.isClientSide()) {
            if (Math.floorMod(i, 40) == 0) {
                pLivingEntity.animateHurt();
                pLivingEntity.playSound(SoundEvents.PLAYER_HURT, 1, 1);
            }
        }
    }
    private void setBlock(LivingEntity pLivingEntity){
        if (pLivingEntity.level.isClientSide()) {
            if (Math.floorMod(i, 10) == 0){
                if(randBlock == -1){
                    randBlock = new Random().nextInt(5);
                }
                if (randBlock == 0) {
                    pLivingEntity.level.setBlock(new BlockPos(pLivingEntity.getRandomX(10), pLivingEntity.getY(), pLivingEntity.getRandomZ(10)), Blocks.LAVA.defaultBlockState(), 2);
                } else if (randBlock == 1) {
                    pLivingEntity.level.setBlock(new BlockPos(pLivingEntity.getRandomX(10), pLivingEntity.getY(), pLivingEntity.getRandomZ(10)), Blocks.DIAMOND_ORE.defaultBlockState(), 2);
                } else {
                    pLivingEntity.level.setBlock(new BlockPos(pLivingEntity.getRandomX(20), pLivingEntity.getY(), pLivingEntity.getRandomZ(20)), Blocks.FIRE.defaultBlockState(), 2);
                }
            }
        }
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if(pLivingEntity.level.isClientSide()) {
            if (Math.floorMod(i, ticks) == 0) {
                random = new Random().nextInt(18);

                int randSound = new Random().nextInt(30);
                if (randSound == 0) {
                    pLivingEntity.playSound(SoundEvents.GUARDIAN_ATTACK, 1, 1);
                } else if (randSound == 1) {
                    pLivingEntity.playSound(SoundEvents.BLAZE_BURN, 1, 1);
                } else if (randSound == 2) {
                    pLivingEntity.playSound(SoundEvents.GOAT_PREPARE_RAM, 1, 1);
                } else if (randSound == 3) {
                    pLivingEntity.playSound(SoundEvents.GHAST_SCREAM, 1, 1);
                } else if (randSound == 4) {
                    pLivingEntity.playSound(SoundEvents.GENERIC_BURN, 1, 1);
                } else if (randSound == 5) {
                    pLivingEntity.playSound(SoundEvents.DROWNED_SHOOT, 1, 1);
                } else if (randSound == 6) {
                    pLivingEntity.playSound(SoundEvents.ENDERMAN_TELEPORT, 1, 1);
                } else if (randSound == 7) {
                    pLivingEntity.playSound(SoundEvents.ENDERMAN_SCREAM, 1, 1);
                } else if (randSound == 8) {
                    pLivingEntity.playSound(SoundEvents.CREEPER_PRIMED, 1, 1);
                } else if (randSound == 9) {
                    pLivingEntity.playSound(SoundEvents.BEE_LOOP_AGGRESSIVE, 1, 1);
                } else if (randSound == 10) {
                    pLivingEntity.playSound(SoundEvents.AMBIENT_CAVE, 1, 1);
                } else if (randSound == 11) {
                    pLivingEntity.playSound(SoundEvents.CROSSBOW_SHOOT, 1, 1);
                } else if (randSound == 12) {
                    pLivingEntity.playSound(SoundEvents.ZOMBIE_AMBIENT, 1, 1);
                } else if (randSound == 13) {
                    pLivingEntity.playSound(SoundEvents.ZOMBIE_ATTACK_WOODEN_DOOR, 1, 1);
                } else if (randSound == 14) {
                    pLivingEntity.playSound(SoundEvents.SKELETON_AMBIENT, 1, 1);
                } else if (randSound == 15) {
                    pLivingEntity.playSound(SoundEvents.ZOMBIE_AMBIENT, 1, 1);
                } else if (randSound == 16) {
                    pLivingEntity.playSound(SoundEvents.CREEPER_PRIMED, 1, 1);
                } else if (randSound == 17) {
                    pLivingEntity.playSound(SoundEvents.GENERIC_EXPLODE, 1, 1);
                }
            }
        }
        if (random == 0) {
            setFire(pLivingEntity);
        } else if (random == 1) {
            setSwim(pLivingEntity);
        } else if (random == 2) {
            pLivingEntity.setIsInPowderSnow(Boolean.TRUE);
        } else if (random == 3) {
            setHurt(pLivingEntity);
        } else if (random == 4) {
            setBlock(pLivingEntity);
        } else if (random == 5) {
            setFire(pLivingEntity);
            setSwim(pLivingEntity);
        } else if (random == 6) {
            pLivingEntity.setIsInPowderSnow(Boolean.TRUE);
            setSwim(pLivingEntity);
        } else if (random == 7) {
            pLivingEntity.setIsInPowderSnow(Boolean.TRUE);
            setBlock(pLivingEntity);
        } else if (random == 8) {
            setFire(pLivingEntity);
            setBlock(pLivingEntity);
        } else if (random == 9 && pLivingEntity.level.isClientSide()) {
            pLivingEntity.level.explode(pLivingEntity, pLivingEntity.getRandomX(30), pLivingEntity.getY(), pLivingEntity.getRandomZ(30), 4.0f, Explosion.BlockInteraction.DESTROY);
            random = 10;
        }

        if (pLivingEntity.level.isClientSide()) i++;

        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public void initializeClient(Consumer<EffectRenderer> consumer) {
        consumer.accept(new EffectRenderer() {
            @Override
            public boolean shouldRender(MobEffectInstance effect) {
                return shouldRender;
            }

            @Override
            public boolean shouldRenderInvText(MobEffectInstance effect) {
                return shouldRender;
            }

            @Override
            public boolean shouldRenderHUD(MobEffectInstance effect) {
                return shouldRender;
            }

            @Override
            public void renderInventoryEffect(MobEffectInstance effectInstance, EffectRenderingInventoryScreen<?> gui, PoseStack poseStack, int x, int y, float z) {

            }

            @Override
            public void renderHUDEffect(MobEffectInstance effectInstance, GuiComponent gui, PoseStack poseStack, int x, int y, float z, float alpha) {

            }
        });
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        if(pAmplifier == 10){
            shouldRender = Boolean.FALSE;
            if(ModEvents.timeout > 0){
                ModEvents.timeout--;
            }
            return ModEvents.timeout == 0;
        } else {
            shouldRender = Boolean.TRUE;
            return true;
        }
    }
}
