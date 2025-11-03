package silence.fixdungeonbreaker.simsool.utils;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemUtils {

	public static String getItemID(ItemStack itemStack) {
		NBTTagCompound attributes = getExtraAttributes(itemStack);
		return attributes != null ? attributes.getString("id") : "";
	}

	public static NBTTagCompound getExtraAttributes(ItemStack item) {
		if (item == null || !item.hasTagCompound()) return null;
		else return item.getSubCompound("ExtraAttributes", false);
	}

}