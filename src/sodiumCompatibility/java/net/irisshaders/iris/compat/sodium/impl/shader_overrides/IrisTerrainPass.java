package net.irisshaders.iris.compat.sodium.impl.shader_overrides;

import me.jellysquid.mods.sodium.client.render.chunk.passes.BlockRenderPass;
import net.minecraft.world.level.block.Block;

public enum IrisTerrainPass {
	SHADOW("shadow"),
	SHADOW_CUTOUT("shadow"),
	GBUFFER_SOLID("gbuffers_terrain"),
	GBUFFER_CUTOUT("gbuffers_terrain_cutout"),
	GBUFFER_TRANSLUCENT("gbuffers_water");

	private final String name;

	IrisTerrainPass(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean isShadow() {
		return this == SHADOW || this == SHADOW_CUTOUT;
	}

	public BlockRenderPass toTerrainPass() {
		switch (this) {
			case SHADOW, GBUFFER_SOLID:
				return BlockRenderPass.SOLID;
			case SHADOW_CUTOUT, GBUFFER_CUTOUT:
				return BlockRenderPass.CUTOUT;
			case GBUFFER_TRANSLUCENT:
				return BlockRenderPass.TRANSLUCENT;
			default:
				return null;
		}
	}
}
