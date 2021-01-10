import React from 'react';
import { Product } from './types';

type Props = {
    product: Product;
}

function priceFormater(price: number) {
    const formatter = new Intl.NumberFormat('pt-BR', {
        style: 'currency',
        currency: 'BRL'
    });
    return formatter.format(price);
}

function ProductCard({ product }: Props) {
    return (
        <div className="order-card-container">
            <h3 className="order-card-title">{product.name}</h3>
            <img src={product.imageUri} alt="Imagem do produto" className="order-card-image" />
            <div className="order-card-price">
                {priceFormater(product.price)}
            </div>
            <div className="order-card-description">
                <h3>Descrição</h3>
                <p>
                    {product.description}
                </p>
            </div>
        </div>
    );
}

export default ProductCard;