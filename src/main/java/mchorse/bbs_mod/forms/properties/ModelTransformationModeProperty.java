package mchorse.bbs_mod.forms.properties;

import mchorse.bbs_mod.data.types.MapType;
import mchorse.bbs_mod.forms.forms.Form;
import net.minecraft.item.ItemDisplayContext;

public class ModelTransformationModeProperty extends BaseProperty<ItemDisplayContext>
{
    public ModelTransformationModeProperty(Form form, String key, ItemDisplayContext value)
    {
        super(form, key, value);
    }

    @Override
    public void toData(MapType data)
    {
        data.putString(this.key, (this.value == null ? ItemDisplayContext.NONE : this.value).asString());
    }

    @Override
    protected void propertyFromData(MapType data, String key)
    {
        String string = data.getString(key);

        this.set(ItemDisplayContext.NONE);

        for (ItemDisplayContext value : ItemDisplayContext.values())
        {
            if (value.asString().equals(string))
            {
                this.set(value);

                break;
            }
        }
    }
}