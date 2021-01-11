import React from 'react';
import { priceFormater } from './helpers';
import { Product } from './types';

type Props = {
    product: Product;
    onSelectProduct: (product: Product) => void;
    isSelected: boolean;
}

function ProductCard({ product, isSelected, onSelectProduct }: Props) {
    return (
        <div className={`order-card-container ${isSelected ? 'selected' : ''}`}
            onClick={() => onSelectProduct(product)}
        >
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