package draylar.trashit.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class TrashCanBlock extends Block implements InventoryProvider {

    private static final VoxelShape COLLISION_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 10.0D, 12.0D),
            Block.createCuboidShape(3.0D, 9.0D, 3.0D, 13.0D, 11.0D, 13.0D)
    );

    public TrashCanBlock() {
        super(FabricBlockSettings.create().sounds(BlockSoundGroup.METAL).hardness(2.0f).nonOpaque());
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!world.isClient && hand == Hand.MAIN_HAND) {
            player.playSound(SoundEvents.BLOCK_IRON_TRAPDOOR_OPEN, SoundCategory.BLOCKS, 1, 1);
            player.openHandledScreen(new SimpleNamedScreenHandlerFactory((syncId, inv, opener) -> {
                return GenericContainerScreenHandler.createGeneric9x3(syncId, inv);
            }, Text.literal("Trash Can")));
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return COLLISION_SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return COLLISION_SHAPE;
    }

    @Override
    public SidedInventory getInventory(BlockState state, WorldAccess world, BlockPos pos) {
        return new DummyInventory();
    }

    static class DummyInventory extends SimpleInventory implements SidedInventory {

        public DummyInventory() {
            super(1);
        }

        public int[] getAvailableSlots(Direction side) {
            return new int[1];
        }

        public boolean canInsert(int slot, ItemStack stack, Direction dir) {
            return true;
        }

        public boolean canExtract(int slot, ItemStack stack, Direction dir) {
            return false;
        }
    }
}
