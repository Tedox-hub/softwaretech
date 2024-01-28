<template>
  <div class="dropdown" :class="{ 'is-active': showDropdown, 'dropdown-open': showDropdown }">
    <button class="dropdown-trigger" @click="toggleDropdown">{{ selectedLabel }}</button>
    <div class="dropdown-menu" v-if="showDropdown">
      <a class="dropdown-item" href="#" v-for="(item, index) in items" :key="index" @click="selectItem(item)">{{ item }}</a>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    items: {
      type: Array,
      default: () => []
    }
  },
  data() {
    return {
      showDropdown: false,
      selectedLabel: 'Choose Role' // This will hold the selected item's label
    };
  },
  methods: {
    toggleDropdown() {
      this.showDropdown = !this.showDropdown;
    },
    selectItem(item) {
      console.log('Selected:', item);
      this.selectedLabel = item; // Update the selected label
      this.showDropdown = false;
      this.$emit('item-selected', item);
    }
  }
};

</script>

<style scoped>
.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-trigger {
  cursor: pointer;
}

.dropdown-menu {
  position: absolute;
  background-color: #333c;
  backdrop-filter: blur(10px);
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
  padding: 12px 16px;
  z-index: 1;
}

.dropdown-item {
  padding: 4px 16px;
  text-decoration: none;
  display: block;
  color: hsl(183, 98%, 28%);
}

.dropdown-item:hover {
  background-color: #5558;
  transform: scale(1.1);
  transition: all 0.5s ease-in-out;
}

button.dropdown-trigger {
  background-color: #111;
  backdrop-filter: blur(10px);
  border: none;
  color: hsl(183, 98%, 28%);
  padding: 16px;
  font-size: 16px;
  border-radius: 4px;
  cursor: pointer;
}

.dropdown-open .dropdown-trigger {
  background-color: #333;
}
</style>

