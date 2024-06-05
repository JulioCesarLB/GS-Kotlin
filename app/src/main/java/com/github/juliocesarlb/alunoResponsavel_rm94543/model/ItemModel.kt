package com.github.juliocesarlb.alunoResponsavel_rm94543.model

data class ItemModel(val praia: String, val estado: String, val cidade: String,  val onRemove: (ItemModel) -> Unit)