# 🚀 Quick Start Guide

Get the Steel Mod up and running in 5 minutes!

## Step 1: Prepare Environment
```bash
cd "c:\Users\Robin\Documents\Minecraft mod projekt\StealMod"
```

## Step 2: Generate Data Files
```bash
./gradlew runDatagen
```
This creates all recipe and model JSON files automatically.

## Step 3: Build the Mod
```bash
./gradlew build
```
Creates the JAR file in `build/libs/`

## Step 4: Test in Game (Optional)
```bash
./gradlew runClient
```
This launches Minecraft with the mod loaded.

## Step 5: Add Textures (Optional)
Create 16×16 PNG files for:
- **Items**: `src/main/resources/assets/template-mod/textures/item/`
- **Blocks**: `src/main/resources/assets/template-mod/textures/block/`

Texture filenames must match item/block IDs.

---

## What You Get

### Items (11 total)
✅ Raw Steel Mixture + Steel Ingot
✅ 5 Tools (pickaxe, axe, shovel, hoe, sword)
✅ 4 Armor pieces (helmet, chestplate, leggings, boots)

### Blocks (4 total)
✅ Steel Block (creeper-proof)
✅ Steel Door (redstone-only)
✅ Steel Trapdoor (redstone-only)
✅ Reinforced Anvil (2× durability)

### Recipes (15+ total)
✅ Crafting recipes for all items
✅ Smelting in Blast Furnace
✅ Tool and armor recipes
✅ Block uncrafting

### Features
✅ 625 tool durability (2.5× iron)
✅ Diamond mining speed (8)
✅ Fire-resistant steel ingots
✅ Full armor set with +4 toughness
✅ Auto-generated models and recipes

---

## File Locations

| Content | Location |
|---------|----------|
| Items | `src/main/java/com/example/item/ModItems.java` |
| Blocks | `src/main/java/com/example/block/ModBlocks.java` |
| Recipes | `src/main/java/com/example/datagen/ModRecipeProvider.java` |
| Materials | `src/main/java/com/example/material/ModToolMaterials.java` |
| Translations | `src/main/resources/assets/template-mod/lang/en_us.json` |
| Textures | `src/main/resources/assets/template-mod/textures/` |

---

## Important IDs

All items and blocks use the prefix: `template-mod:`

Examples:
- `template-mod:stahlbarren` - Steel Ingot
- `template-mod:stahl_schwert` - Steel Sword
- `template-mod:stahl_block` - Steel Block

Use these in commands:
```
/give @s template-mod:stahlbarren 64
/give @s template-mod:stahl_helm 1
```

---

## Troubleshooting

### Build fails with "Cannot find symbol"
→ Run `./gradlew clean build` to rebuild from scratch

### Models not loading
→ Run `./gradlew runDatagen` to generate JSON files

### Textures appear purple/missing
→ Create PNG texture files in `textures/item/` and `textures/block/`

### Java version error
→ Requires Java 25+. Check: `java -version`

---

## Documentation

For more information, read:
- `COMPLETE_SUMMARY.md` - Full implementation overview
- `STEEL_MOD_DOCUMENTATION.md` - Complete feature guide
- `DEVELOPER_GUIDE.md` - For extending the mod
- `REGISTRY_REFERENCE.md` - Item/block IDs

---

## Common Commands

```bash
# Clean build
./gradlew clean build

# Generate data
./gradlew runDatagen

# Run client (single-player test)
./gradlew runClient

# Run server (multiplayer test)
./gradlew runServer

# Check for errors
./gradlew check
```

---

## What's Implemented ✅

- [x] All 11 steel items
- [x] All 4 steel blocks
- [x] All tool recipes
- [x] All armor recipes
- [x] Complete smelting recipes
- [x] Tool materials (625 durability, 8 speed)
- [x] Armor materials (18 prot, +4 toughness)
- [x] Fire resistance for ingots
- [x] Creeper-proof steel blocks
- [x] Redstone-only doors
- [x] Automatic model generation
- [x] English translations
- [x] Block/item tags
- [x] Mixin framework

---

## What's Missing 🎨

- [ ] Textures for items and blocks (ready for you to create!)
- [ ] Advanced mixin implementations (framework ready)
- [ ] Additional language translations

---

**The Steel mod is fully functional and ready to use!**

For textures, create 16×16 PNG files and place them in the appropriate directories. Everything else is already implemented and integrated.

Good luck with your Steel mod! ⚔️🛡️
