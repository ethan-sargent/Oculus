package net.coderbot.iris.mixin.rendertype;

import net.minecraft.client.renderer.RenderStateShard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
@Mixin(RenderStateShard.class)
public interface RenderStateShardAccessor {
	@Accessor("name")
	String getName();

	// TODO(1.17): translucent transparency accessor
	/*@Accessor("TRANSLUCENT_TRANSPARENCY")
	static RenderPhase.Transparency getTranslucentTransparency() {
		return null;
	}*/
}
