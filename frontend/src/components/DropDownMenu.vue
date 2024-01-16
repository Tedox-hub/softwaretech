<template>
  <div>
    <b-form-select v-model="selected" :options="options"></b-form-select>
    <div class="mt-3">Selected: <strong>{{ selected }}</strong></div>
  </div>
</template>

<script setup lang="ts">
export default {
  data(): { selected: string | null; options: { value: string | null; text: string; disabled?: boolean }[] } {
    return {
      selected: null,
      options: [
        { value: null, text: 'Please select some item' },
        { value: 'a', text: 'Product Owner' },
        { value: 'b', text: 'This is not an option:' },
        { value: 'c', text: 'Tester' },
        { value: 'd', text: 'This one is disabled', disabled: true },
        { value: 'c', text: 'Dev rawrrr UwU' },
      ],
    };
  },
};

</script>