# Steel Mod Textures

This directory contains the texture files for the Steel mod.

## Required Textures

### Items (16x16 PNG)
- `stahlbarren.png` - Steel Ingot
- `rohstahl_gemisch.png` - Raw Steel Mixture
- `stahl_schwert.png` - Steel Sword
- `stahl_spitzhacke.png` - Steel Pickaxe
- `stahl_axt.png` - Steel Axe
- `stahl_schaufel.png` - Steel Shovel
- `stahl_hacke.png` - Steel Hoe
- `stahl_helm.png` - Steel Helmet
- `stahl_brustpanzer.png` - Steel Chestplate
- `stahl_hose.png` - Steel Leggings
- `stahl_schuhe.png` - Steel Boots

### Blocks (16x16 PNG)
- `stahl_block.png` - Steel Block (full texture)
- `stahl_door_bottom.png` - Steel Door bottom half
- `stahl_door_top.png` - Steel Door top half
- `stahl_trapdoor.png` - Steel Trapdoor

## Recommended Texture Style

- **Color Scheme**: Dark gray/silver metallic (#3A3A3A to #5A5A5A)
- **Style**: Similar to Iron textures but with more reflective quality
- **Details**: Add some metallic highlights for the steel shine effect

## Texture Mapping

The textures are automatically mapped to items/blocks through the data generator:
- Item textures should be placed in `item/` and referenced as `texture: "item/<name>"`
- Block textures should be placed in `block/` and referenced as `texture: "block/<name>"`

Generated models will automatically create proper UV mapping for these textures.
