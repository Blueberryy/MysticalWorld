package epicsquid.mysticalworld.items.materials;

import epicsquid.mysticallib.material.BaseArmorMaterial;
import epicsquid.mysticallib.material.BaseItemTier;
import epicsquid.mysticallib.material.IMaterial;
import epicsquid.mysticalworld.MysticalWorld;
import epicsquid.mysticalworld.items.ModItems;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvents;

import java.util.HashMap;
import java.util.Map;

public class CopperMaterial implements IMaterial {

	private static final String SWORD = "SWORD";
	private static final String KNIFE = "KNIFE";
	private static final String PICKAXE = "PICKAXE";
	private static final String AXE = "AXE";
	private static final String SHOVEL = "SHOVEL";
	private static final String HOE = "HOE";
	private static final String SPEAR = "SPEAR";

	private int enchantability = 7;

	private Map<String, Float> damage = new HashMap<>();
	private Map<String, Float> speed = new HashMap<>();

	public CopperMaterial() {
		damage.put(SWORD, 3.0f);
		damage.put(SHOVEL, 1.5f);
		damage.put(PICKAXE, 1.0f);
		damage.put(AXE, 6.0f);
		damage.put(KNIFE, 2.5f);

		speed.put(SWORD, -2.4f);
		speed.put(SHOVEL, -3.0f);
		speed.put(PICKAXE, -2.8f);
		speed.put(AXE, -3.1f);
		speed.put(KNIFE, -1.5f);
		speed.put(HOE, -1.0f);
	}

	@Override
	public IItemTier getTier() {
		return new BaseItemTier(200, 4.0f, 2.0f, 2, enchantability, () -> Ingredient.fromItems(ModItems.COPPER_INGOT));
	}

	@Override
	public IArmorMaterial getArmor() {
		return new BaseArmorMaterial(getName(), 15, new int[]{2, 5, 6, 2}, enchantability, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, () -> Ingredient.fromItems(ModItems.COPPER_INGOT));
	}

	@Override
	public Item.Properties getProps() {
		return new Item.Properties().group(MysticalWorld.ITEM_GROUP);
	}

	@Override
	public float getAttackSpeed(String name) {
		return speed.getOrDefault(name, 1.0f);
	}

	@Override
	public float getAttackDamage(String name) {
		return damage.getOrDefault(name, 1.0f);
	}

	@Override
	public String getName() {
		return "copper";
	}
}