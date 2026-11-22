<p align="center">
  <img src="src/main/resources/assets/hotbaritemname/icon.png" alt="Toggle Tooltips icon" width="128">
</p>
<h1 align="center">Toggle Tooltips</h1>

<p align="center">
  Hide the item name that pops up above the hotbar when you hold or switch items.
  <br><br>
  <img src="https://img.shields.io/badge/Minecraft-26.2-62B47A" alt="Minecraft 26.2">
  <img src="https://img.shields.io/badge/Fabric-0.19.1%2B-DBD0B4" alt="Fabric Loader 0.19.1+">
  <img src="https://img.shields.io/badge/Java-25-orange" alt="Java 25">
  <img src="https://img.shields.io/badge/Side-Client-blue" alt="Client-side">
</p>

## ✨ Features

- Show or hide the held-item name above the hotbar (**hidden by default**), all other tooltips stay untouched
- One on/off button in the settings screen via [Mod Menu](https://modrinth.com/mod/modmenu)
- Client command to open the settings or switch directly
- Saved automatically
- Client-side only, works on any server
- English, German, French and Spanish

## 📦 Requirements

Minecraft **26.2** · Fabric Loader **0.19.1+** · [Fabric API](https://modrinth.com/mod/fabric-api) · Java **25** · [Mod Menu](https://modrinth.com/mod/modmenu) *(optional)*

## 🚀 Usage

| Command | Effect |
| --- | --- |
| `/hotbaritemname` | Opens the settings screen |
| `/hotbaritemname on` | Shows the item name |
| `/hotbaritemname off` | Hides the item name |

## 🔧 How it works

The mod wraps Fabric API's vanilla HUD element for the held-item tooltip (`VanillaHudElements.HELD_ITEM_TOOLTIP`) and only lets it render when the option is enabled. No mixins.

## 📄 Source & License

This repository is for viewing the source code only, build instructions are intentionally not included. License: [LICENSE.txt](LICENSE.txt).
 