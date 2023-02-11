import {LitElement, html} from 'lit';
import {customElement, property} from 'lit/decorators.js';
import {unsafeHTML} from 'lit/directives/unsafe-html.js';

@customElement('menu-items')
export class MenuItems extends LitElement {

    @property()
    content = '';

    constructor() {
        super();
        this.fetchData()
            .then((response) => response.text())
            .then((data) => {
                this.content = data;
            });
    }

    createRenderRoot() {
        return this; // turn off shadow dom to access external styles
    }

    async fetchData() {
        const response = fetch("http://localhost:8082/menu-items");
        return response;
    }
    
    render() {
        return html`${unsafeHTML(this.content)}`;
    }
}
