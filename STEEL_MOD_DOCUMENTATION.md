# Steel Mod Implementation

This mod adds Steel as a new mid-game material to Minecraft, positioned between Iron and Diamond.

## Features Implemented

### 1. Steel Items & Crafting
- **Rohstahl-Gemisch (Raw Steel Mixture)**: Crafted from 1 Iron Ingot + 4 Coal/Charcoal
- **Stahlbarren (Steel Ingot)**: Smelted from Raw Steel Mixture in Blast Furnace
  - Fire resistant (cannot be destroyed by fire or explosions in lava)
  - Only lava can destroy dropped steel ingots

### 2. Steel Tools
All tools have the following stats:
- **Durability**: 625 uses (2.5x more than Iron, less than Diamond's 1561)
- **Mining Speed**: 8 (same as Diamond)
- **Attack Damage**: 7 damage (3.5 hearts) for sword
- **Mining Level**: 2 (can mine Iron/Gold but not Obsidian/Diamond)
- **Cannot mine**: Obsidian blocks

Available tools:
- Steel Pickaxe
- Steel Axe
- Steel Shovel
- Steel Hoe
- Steel Sword

### 3. Steel Armor
Complete armor set:
- **Helmet** (3 prot)
- **Chestplate** (7 prot)
- **Leggings** (6 prot)
- **Boots** (2 prot)

Total set stats:
- **Protection**: 18 points (3 more than Iron, 2 less than Diamond)
- **Toughness**: +4 total (+1 per piece) - reduces damage from critical hits and heavy attacks
- **Special Properties**:
  - Loses durability 50% slower from explosions/fire
  - Full set provides +20% passive explosion damage reduction
  - Full set reduces fire damage by 20%

### 4. Steel Blocks
- **Steel Block**: 
  - Complete Creeper explosion resistance
  - Can be moved by pistons (unlike obsidian)
  - Perfect for bomb-proof redstone bunkers
  
- **Steel Door**: 
  - Only responds to redstone signals (like iron door)
  - Zombies on Hard difficulty cannot break it
  
- **Steel Trapdoor**: 
  - Only responds to redstone signals
  
- **Reinforced Anvil**: 
  - Created on Smithing Table: Normal Anvil + Steel Blocks
  - Can be used 2x as often before breaking

## Crafting Recipes

### Ingot Creation
```
Raw Steel Mixture (1 Iron Ingot + 4 Coal):
CCC
CIC
CCC

Steel Ingot (Blast Furnace):
Raw Steel Mixture -> Steel Ingot (100 ticks, 0.1 XP)
```

### Block Recipes
```
Steel Block (9 ingots):
SSS
SSS
SSS

Steel Door (6 ingots):
SS
SS
SS

Steel Trapdoor (4 ingots):
SSS
SSS
```

### Tools
```
Pickaxe (3 ingots + 2 sticks):
SSS
 # 
 # 

Sword (2 ingots + 1 stick):
S
S
#

Axe (3 ingots + 2 sticks):
SS
S#
 #

Shovel (1 ingot + 2 sticks):
S
#
#

Hoe (2 ingots + 2 sticks):
SS
 # 
 # 
```

### Armor
```
Helmet (5 ingots):
SSS
S S

Chestplate (8 ingots):
S S
SSS
SSS

Leggings (7 ingots):
SSS
S S
S S

Boots (4 ingots):
S S
S S
```

## Material Properties

| Property | Iron | Steel | Diamond |
|----------|------|-------|---------|
| Durability | 250 | 625 | 1561 |
| Mining Speed | 6 | 8 | 8 |
| Sword Damage | 6 (3♥) | 7 (3.5♥) | 7 (3.5♥) |
| Mine Obsidian | No | No | Yes |
| Armor Points | 15 | 18 | 20 |
| Armor Toughness | 0 | +4 | +8 |
| Special Effect | None | -50% fire/explosion durability loss | None |

## Building & Running

Requirements:
- Java 25+
- Gradle

Build the mod:
```bash
./gradlew build
```

Generate data (recipes, models, loot tables):
```bash
./gradlew runDatagen
```

Run client:
```bash
./gradlew runClient
```

Run server:
```bash
./gradlew runServer
```

## File Structure

```
src/main/java/com/example/
├── TemplateMod.java              # Main mod entry point
├── item/ModItems.java             # Item definitions
├── block/ModBlocks.java           # Block definitions
├── material/ModToolMaterials.java # Tool/armor materials
├── recipe/ModRecipes.java         # Recipe registration
├── datagen/
│   ├── ModRecipeProvider.java     # Recipe data generation
│   ├── ModModelProvider.java      # Model data generation
│   └── ModBlockLootTableProvider.java # Loot table generation
└── mixin/
    ├── SteelItemMixin.java        # Item property mixins
    ├── SteelArmorMixin.java       # Armor property mixins
    └── SteelBlockExplosionMixin.java # Block explosion mixins

src/main/resources/
├── assets/template-mod/
│   ├── lang/en_us.json           # English translations
│   ├── textures/
│   │   ├── item/                 # Item textures
│   │   └── block/                # Block textures
│   └── models/
│       ├── item/                 # Item models
│       └── block/                # Block models
├── data/minecraft/tags/
│   ├── block/needs_iron_tool.json
│   └── item/armor_enchantable.json
├── template-mod.mixins.json      # Mixin configuration
└── fabric.mod.json               # Mod metadata
```

## Mod ID
`template-mod`

All items and blocks are prefixed with `template-mod:`

Example: `template-mod:stahlbarren`, `template-mod:stahl_schwert`

## Special Behaviors (Implemented via Mixins)
1. Steel items cannot be destroyed by fire/explosions (fireResistant flag)
2. Steel armor provides special fire resistance when full set is worn
3. Steel blocks cannot be destroyed by creeper explosions
4. Steel blocks can be moved by pistons

## Notes
- The mod balances Steel as a mid-game material, providing better durability than Iron
- Steel mining speed matches Diamond, but cannot mine obsidian
- Special explosion/fire resistance makes Steel superior to Iron for specific uses
- The Reinforced Anvil extends tool life significantly

## Future Enhancements (Not yet implemented)
- Custom textures for steel blocks and items
- Smithing recipes for upgrading iron to steel tools
- Decorative steel variants (stairs, slabs, walls)
- Steel beacon base (replaces emerald in beacon pyramid)
