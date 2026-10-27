<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

const api = axios.create({ baseURL: 'http://localhost:8080/api' })
const phones = ref([])
const form = ref({ name: '', brand: '', price: 0, stock: 0 })

async function loadPhones() {
  const res = await api.get('/phones')
  phones.value = res.data
}

async function addPhone() {
  await api.post('/phones', form.value)
  form.value = { name: '', brand: '', price: 0, stock: 0 }
  await loadPhones()
}

async function removePhone(id) {
  await api.delete(`/phones/${id}`)
  await loadPhones()
}

onMounted(loadPhones)
</script>

<template>
  <div class="box">
    <h1>Phone Shop</h1>

    <div class="form">
      <input v-model="form.name" placeholder="Tên" />
      <input v-model="form.brand" placeholder="Hãng" />
      <input v-model.number="form.price" type="number" placeholder="Giá" />
      <input v-model.number="form.stock" type="number" placeholder="Tồn kho" />
      <button @click="addPhone">Thêm</button>
    </div>

    <table>
      <thead>
        <tr><th>ID</th><th>Tên</th><th>Hãng</th><th>Giá</th><th>Tồn kho</th><th></th></tr>
      </thead>
      <tbody>
        <tr v-for="p in phones" :key="p.id">
          <td>{{ p.id }}</td>
          <td>{{ p.name }}</td>
          <td>{{ p.brand }}</td>
          <td>{{ p.price }}</td>
          <td>{{ p.stock }}</td>
          <td><button @click="removePhone(p.id)">Xóa</button></td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style scoped>
.box { max-width: 800px; margin: 40px auto; }
.form { display: flex; gap: 8px; margin-bottom: 20px; }
input { padding: 6px; }
table { width: 100%; border-collapse: collapse; }
th, td { border: 1px solid #888; padding: 8px; text-align: left; }
</style>