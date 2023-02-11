import {LitElement, html} from 'lit';
import {customElement} from 'lit/decorators.js';

@customElement('header-section')
export class Header extends LitElement {

    createRenderRoot() {
        return this; // turn off shadow dom to access external styles
    }
    
    render() {
        return html`
            <header class="flex items-center justify-between p-4 bg-gray-200">
                <logo-section></logo-section>
                <search-bar></search-bar>
                <mega-menu-button></mega-menu-button>
            </header>
            <menu-items></menu-items>
        `;
    }
}
