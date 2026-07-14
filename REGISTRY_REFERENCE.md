# Steel Mod Item & Block Registry

Complete list of all Steel mod items and blocks with their unique identifiers.

## Items

### Ingots
| Name | ID | Description |
|------|----|----|
| Raw Steel Mixture | `template-mod:rohstahl_gemisch` | Intermediate crafting material |
| Steel Ingot | `template-mod:stahlbarren` | Main material, fire-resistant |

### Tools
| Name | ID | Description |
|------|----|----|
| Steel Pickaxe | `template-mod:stahl_spitzhacke` | 625 durability, 8 speed |
| Steel Axe | `template-mod:stahl_axt` | 6 attack speed |
| Steel Shovel | `template-mod:stahl_schaufel` | 1.5 attack speed |
| Steel Hoe | `template-mod:stahl_hacke` | -1 attack speed |
| Steel Sword | `template-mod:stahl_schwert` | 7 damage (3.5 hearts) |

### Armor
| Name | ID | Type | Protection |
|------|----|----|---|
| Steel Helmet | `template-mod:stahl_helm` | Head | 3 |
| Steel Chestplate | `template-mod:stahl_brustpanzer` | Chest | 7 |
| Steel Leggings | `template-mod:stahl_hose` | Legs | 6 |
| Steel Boots | `template-mod:stahl_schuhe` | Feet | 2 |

**Full Set**: 18 protection points, +4 toughness

## Blocks

| Name | ID | Material | Properties |
|------|----|----|---|
| Steel Block | `template-mod:stahl_block` | Solid | Creeper-proof, piston-moveable |
| Steel Door | `template-mod:stahl_door` | Wooden | Redstone-only, zombie-proof (Hard) |
| Steel Trapdoor | `template-mod:stahl_trapdoor` | Wooden | Redstone-only |
| Reinforced Anvil | `template-mod:verstaerkter_anvil` | Solid | 2x uses before breaking |

## Usage Examples

### Command Examples
```bash
# Give player steel ingots
/give @s template-mod:stahlbarren 64

# Give player full steel armor
/give @s template-mod:stahl_helm 1
/give @s template-mod:stahl_brustpanzer 1
/give @s template-mod:stahl_hose 1
/give @s template-mod:stahl_schuhe 1

# Give player all tools
/give @s template-mod:stahl_schwert 1
/give @s template-mod:stahl_spitzhacke 1
/give @s template-mod:stahl_axt 1
/give @s template-mod:stahl_schaufel 1
/give @s template-mod:stahl_hacke 1

# Fill area with steel blocks
/fill ~0 ~0 ~0 ~10 ~10 ~10 template-mod:stahl_block
```

### Enchanting
All steel tools and armor can be enchanted just like iron equivalents.
Steel tools support Fortune, Efficiency, Unbreaking, etc.
Steel armor supports Protection, Fire Protection, Blast Protection, etc.

### Crafting
See STEEL_MOD_DOCUMENTATION.md for detailed crafting recipes.

## Translation Keys

### Items
```
item.template-mod.rohstahl_gemisch
item.template-mod.stahlbarren
item.template-mod.stahl_spitzhacke
item.template-mod.stahl_axt
item.template-mod.stahl_schaufel
item.template-mod.stahl_hacke
item.template-mod.stahl_schwert
item.template-mod.stahl_helm
item.template-mod.stahl_brustpanzer
item.template-mod.stahl_hose
item.template-mod.stahl_schuhe
```

### Blocks
```
block.template-mod.stahl_block
block.template-mod.stahl_door
block.template-mod.stahl_trapdoor
block.template-mod.verstaerkter_anvil
```

## Mod ID
`template-mod`

All items and blocks are part of the `template-mod` namespace.
